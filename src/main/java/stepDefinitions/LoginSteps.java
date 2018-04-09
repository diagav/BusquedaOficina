package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class LoginSteps {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
	}

	@After
	public void tearDown() {
		// driver.quit();
	}

	@Given("el usuario esta en la pagina del grupo bancolombia")
	public void usuarioEstaEnPaginaGrupoBancolombia() {
		driver.get("https://www.grupobancolombia.com/wps/portal/personas");				
	}

	@When("el usuario ingresa a la opcion visitanos")
	public void usuarioIngresaOpcionVisitanos() {
		driver.findElement(By.xpath("//*[@id=\'footer-content\']/div[1]/div/div/div[4]/div/a/img")).click();
	}

	@And("el usuario ingresa la ciudad o sector")
	public void usuarioIngresaCiudad() {
		driver.findElement(By.id("srch-term")).click();
		driver.findElement(By.id("srch-term")).sendKeys("Envigado");
		driver.findElement(By.xpath("//*[@id=\'tab1\']/div[1]/div[1]/div")).click();
	}
	
	@Then("el usuario puede ver la lista de las sucursales cercanas")
	public void usuarioVeListaSucursales() throws InterruptedException {
		String resultado = driver.findElement(By.xpath("//*[@id=\'tab1\']/div[1]/div[6]/div[1]/div/div[2]/h3[1]")).getText();
		Thread.sleep(10000);
    	driver.findElement(By.xpath("//*[@id=\'tab1\']/div[1]/div[6]/div[1]/div/div[1]/button")).click();
    	Thread.sleep(10000);
		System.out.println(resultado);
		assertEquals("ENVIGADO", resultado);
		}

    @When("el usuario captura la direccion del primer resultado que arroja la lista")
    public void usuarioCapturaDireccion() {
    	String resultado = driver.findElement(By.xpath("//*[@id=\'tab1\']/div[1]/div[6]/div[1]/div/div[2]/p")).getText();
    	System.out.println(resultado);
		driver.findElement(By.id("srch-term")).click();
		driver.findElement(By.id("srch-term")).clear();
		driver.findElement(By.id("srch-term")).sendKeys(resultado);
		driver.findElement(By.xpath("//*[@id=\'tab1\']/div[1]/div[1]/div")).click();
    }

}
