Feature: API de Departamentos de Mercado Libre

  @api
  Scenario: Verificar que el servicio de departamentos de Mercado Libre responde correctamente
    Given configuro la base URL de la API a "https://www.mercadolibre.com.ar"
    When realizo una petición GET al endpoint "/menu/departments"
    Then el código de estado de la respuesta debe ser 200
    And la respuesta del servicio debe contener el listado de departamentos