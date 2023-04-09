<h1 align="center"> Conversores </h1>
<p>
  Aplicación de conversiones.
  
</p>

![ezgif com-video-to-gif](https://user-images.githubusercontent.com/101782933/229208668-ce2a45d7-8120-45bb-ad16-496ca7714c11.gif)

<h2> Descripción </h2>
<p>
  Aplicación que permite elegir entre tres diferentes conversores permitiendo
  calculos rapidos y precisos
  
  Aunque son conversores parecidos, cada uno realiza su conversión de una manera diferente.
  
</p>

<h2> Explicación y demostración </h2>

<p>
  La aplicación inicia con una ventana controladora.
</p>

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

<p>  
  Este conversor cuenta con las siguientes caracteristicas:

  - Calculos automaticos a medida que se escribe en el campo de texto.
  - Uso de API https://api.exchangerate-api.com/v4/latest/COP para obtención de los
  rates y código de las monedas
  - Uso de API https://openexchangerates.org/api/currencies.json para obtención de
  los nombres de las monedas (en inglés)
  - Los resultados se muestran en la tabla y en un segundo campo de texto.
  - El segundo campo de texto es de solo lectura.
  - Boton de intercambio de valor de los combobox.
  - Al dar doble click en una fila de la tabla, desplegará una ventana extra con la
  información contenida en dicha fila.
  - Cantidad de cifras permitidas dentro del primer campo de texto a un maximo de 15.
  - El conversor de monedas permite realizar los calculos rapidamente de 158 monedas diferentes.
  - Resultados redondeados a dos cifras decimales.
  - No permite el ingreso de numeros negativos, letras o simbolos.
  - Permite el ingreso de numeros decimales.
  - La cuarta columna de la tabla muestra la tasa de cambio con la que podemos calcular la conversión
  entre la moneda seleccionada en el primer combobox y la moneda perteneciente a la fila que
  contiene dicha tasa de cambio
</p>

![4](https://user-images.githubusercontent.com/101782933/229081986-951473d6-071a-41e4-ac8d-606ad475b529.gif)

<h2> Conversor de temperatura 🌡️</h2>

![image](https://user-images.githubusercontent.com/101782933/229082784-689b5dd9-6f44-438e-b4f0-1df8716e5cdf.png)

<p>
  El funcionamiento viene siendo similar al de "Tasa de cambio de divisas" y podemos verlo en el siguiente gif
</p>

![5](https://user-images.githubusercontent.com/101782933/229084806-aa1162ca-ae0a-485c-bcf7-4e526fe182d1.gif)

<p>
  Las caracteristicas de este conversor son:
  
  - Calculos automaticos a medida que se escribe en el campo de texto.
  - Los resultados se muestran en la tabla.
  - Al dar doble click en una fila de la tabla, desplegará una ventana extra con la
  información contenida en dicha fila.
  - Cantidad de cifras permitidas dentro del campo de texto a un maximo de 15 (16 si es un numero negativo).
  - Resultados redondeados a dos cifras decimales.
  - No permite el ingreso de letras o simbolos.
  - Permite el ingreso de numeros decimales y numeros negativos.
  - En la tabla encontramos la formula empleada para realizar la conversión.
</p>


<h2> Conversor de sistemas numéricos 🔢</h2>

![6](https://user-images.githubusercontent.com/101782933/229086540-11292fa2-0c88-44e0-a472-37e6c91d8f81.gif)

<p>
  Las caracteristicas de este conversor son:
  - Calculos automaticos a medida que se escribe en el campo de texto.
  - Los resultados se muestran en la tabla.
  - Al dar doble click en una fila de la tabla, desplegará una ventana extra con la
  información contenida en dicha fila.
  - Cantidad de cifras permitidas dentro del campo de texto (dependiendo del sistema numérico seleccionado)
  - Permite el ingreso de numeros negativos.
</p>

<p>
  Para este conversor, fue necesario limitar los valores ingresados al campo de texto dependiendo 
  al sistema numerico seleccionado. 
  
  - El sistema binario por su parte, esta compuesta por "1" y "0".
  - El sistema octal por su parte, esta compuesto por cifras que van del "0" al "7"
  - Por otro lado, el sistema hexadecimal, debia permitir el acceso de los numeros y letras.
  (dentro de la aplicación se podran usar las letras "A" "B" "C" "D" "E" "F" en mayuscula)
  
</p>

<h2> Tecnologías utilizadas 💻</h2>

<p>
  - La aplicación esta construida en el lenguaje java.
  - Se utilizó la libreria javax.swing para la construcción de las interfaces graficas.
  - Clase BigDecimal para realizar los calculos grandes y precisos.
</p>

<h2> Redes </h2>

<a href="https://github.com/zucarion7" target="_BLANK">
  <img widht="70" height="70" src="https://user-images.githubusercontent.com/101782933/229203774-0bc9b976-0788-41a2-87af-1d4e819aa943.png">
 </a>

<a href="https://www.instagram.com/zucarion7/" target="_BLANK">
  <img widht="60" height="60" src="https://user-images.githubusercontent.com/101782933/229204673-7260f3c5-d6f3-4ff5-96a8-686dacde5557.png">
 </a>

<a href="https://www.linkedin.com/in/zucarion7/" target="_BLANK">
  <img widht="70" height="70" src="https://user-images.githubusercontent.com/101782933/229201751-ddd8422a-5f33-4ea1-946f-2d06a2effa7a.png">
 </a>
