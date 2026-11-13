@saucedemo
Feature: Inicio de Sesión en Sauce Demo

  Background:
    Given el usuario navega a la URL de Sauce Demo

  @login @positivo
  Scenario: Login exitoso con credenciales válidas
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    Then se muestra el catálogo de productos de Sauce Demo

  @login @negativo @fallo_intencional
  Scenario Outline: Validacion de errores en el inicio de sesión
    When ingresa el usuario "<usuario>" y la contraseña "<contrasena>"
    Then se muestra el mensaje de error "<mensaje_esperado>"

    Examples:
      | usuario         | contrasena    | mensaje_esperado                                                          |
      | locked_out_user | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                       |
      | standard_user   | bad_password  | Epic sadface: Username and password do not match any user in this service |
      |                 |               | Epic sadface: Username is required                                        |
      | standard_user   | clave_erronea | Epic sadface: Texto que no corresponde                                    |