Feature: Busqueda en la pagina de Bancolombia de las oficinas mas cercanas
  Yo como cliente de bancolombia
  Quiero ingresar a la pagina de bancolombia 
  Para buscar en la opcion visitanos la oficina mas cercana a mi ubicacion

 Scenario: Buscar oficina
    Given el usuario esta en la pagina del grupo bancolombia
    When el usuario ingresa a la opcion visitanos 
    And el usuario ingresa la ciudad o sector
    Then el usuario puede ver la lista de las sucursales cercanas
    And el usuario captura la direccion del primer resultado que arroja la lista 


 