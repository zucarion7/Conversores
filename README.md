<h1 align="center"> Conversores </h1>
Aplicación de conversiones.

<h2> Descripción </h2>
Aplicación que permite elegir entre tres diferentes conversores permitiendo
calculos rapidos y precisos

<h2> Explicación y demostración </h2>

La aplicación inicia con una ventana controladora.

![image](https://user-images.githubusercontent.com/101782933/229003155-7e1d29ce-0123-499c-909f-1d88d99c2dd7.png)

<p>
  Como podemos apreciar, esta ventana consta de una zona de encabezado, una zona central
  y una zona de pie de página.

  En la zona de encabezado tenemos un titulo para indicar en que ventana y/o conversor nos encontramos, además
  de un boton para cambiar el color de fondo.
</p>

![ezgif com-video-to-gif](https://user-images.githubusercontent.com/101782933/229005869-d146f93c-dcf9-47c5-b341-6c3bbdd5354e.gif)

<p>
  Dentro de esta aplicación encontramos tres tipos
  de conversores:
  
  - Tasa de cambio de divisas
  - Conversor de temperatura
  - Conversor de sistemas numéricos
</p>

![2](https://user-images.githubusercontent.com/101782933/229021862-b4d5c995-8e85-45b3-adc6-24c63f638967.gif)

<h2> Tasa de cambio de divisas 💰</h2>

![3](https://user-images.githubusercontent.com/101782933/229025107-713664f8-8435-477e-85db-817e5368dabb.gif)

![image](https://user-images.githubusercontent.com/101782933/229026201-daefc95c-4c9e-44c2-be68-0fa114742ff5.png)

El conversor de monedas permite realizar los calculos rapidamente de 158 monedas diferentes redondeando a dos
cifras decimales. Aunque no permite el ingreso de numeros negativos, permite el ingreso de numeros decimales.

En la ventana encontramos dos combobox con los cuales podemos indicar dos monedas. El primer combobox
nos indica desde que moneda se realizará la conversión y el segundo combobox nos indica hacia cual moneda
queremos realizar dicha conversión.

Tambien encontramos dos campos de texto. El primer campo de texto es el campo que nos permitirá ingresar el valor a
convertir. Para mayor experiencia del usuario y evitar la preocupación de ingresar letras o simbolos, este campo
desechará cualquier letra o simbolo que se escriba permitiendo asi solo el ingreso de numeros. Para el ingreso de numeros
decimales, se utilizará el punto. Se restringio su ingreso solo si el campo de texto 
posee algún numero. Al ingresar datos en este combobox, las conversiones se haran automaticamente.

el campo de texto dos es de solo lectura y en el se escribirá automaticamente la conversión realizada desde la moneda seleccionada
por el combobox uno hacia la moneda seleccionada en el combobox.

tambien encontramos dos etiquetas que indican en que fila de la tabla podemos encontrar la moneda seleccionada en su respectivo
combobox.



Entre los combobox encontramos un boton que permite intercambiar la moneda desde la que se hará la conversión y la moneda hacia la
cual se hará la conversión.

La tabla posee cinco columnas. La primera columna nos permite tener un conteo de monedas y facilidad para encontrar las monedas
seleccionadas en los combobox.

La segunda columna nos dice el nombre de la moneda en inglés.

La tercera columna nos dice el código de tres letras de la moneda.

La cuarta columna nos dice la tasa con la que podemos calcular la conversión de la moneda seleccionada en el combobox uno
hacia la moneda que se encuentra en la tabla.

La quinta columna nos arroja el valor de la conversión realizada desde la moneda seleccionada en el combobox uno hacia la
moneda en la tabla.
