@saucedemo
Feature: Gestión del carrito de compras en Sauce Demo

  Background:
    Given el usuario navega a la URL de Sauce Demo
    And ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And se muestra el catálogo de productos de Sauce Demo

  @carrito @positivo
  Scenario: Agregar un único producto desde el catálogo principal
    When agrega el primer producto al carrito
    Then el contador del carrito muestra "1"

  @carrito @positivo
  Scenario: Agregar múltiples productos al carrito
    When agrega el primer producto al carrito
    And agrega el segundo producto al carrito
    Then el contador del carrito muestra "2"

  @carrito @positivo
  Scenario: Agregar y luego remover un producto desde el catálogo
    When agrega el primer producto al carrito
    And remueve el primer producto desde el catálogo
    Then el contador del carrito desaparece

  @carrito @positivo
  Scenario: Agregar un producto desde la vista de detalle
    When hace clic en el título del primer producto
    And agrega el producto al carrito desde su vista de detalle
    Then el contador del carrito muestra "1"