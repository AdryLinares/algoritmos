**AnÃ¡lisis ProbabilÃ­stico**
===================
El uso del anÃ¡lisis probabilÃ­stico puede ser muy Ãºtil para la gestiÃ³n de riesgos en paÃ­ses en desarrollo, donde la informaciÃ³n, recursos y la especializaciÃ³n tÃ©cnica es a menudo escasa. Actualmente, la mayorÃ­a de las agencias regulatorias en el mundo recomiendan el uso de los enfoques determinÃ­sticos para el anÃ¡lisis de los problemas relacionados con la toma de decisiones. Sin embargo, este enfoque no incorpora la incertidumbre en las variables, ni su propagaciÃ³n a travÃ©s de los distintos procesos en que intervienen. Con ello se reduce arbitrariamente la complejidad del problema y se desaprovecha informaciÃ³n valiosa para la definiciÃ³n de polÃ­ticas realistas que, junto con proteger la salud, sean factibles tÃ©cnicamente y razonables econÃ³micamente. 

 1. Mejor caso   $t \big(x\big) \equiv $ tiempo que tarda el algoritmo
    para la entrada x. $\hspace{1cm}T\big(n\big) =$ min $\big\{t \big(x\big) \big\}$ ,  | x | = n
 
 2. Peor Caso $\hspace{1cm}T\big(n\big) =$ max $\big\{t \big(x\big) \big\}$ ,  | x | = n
 3. Caso Promedio
Se obtiene la esperanza sobre la distribuciÃ³n de las entradas, de donde se promedia el tiempo de corrida para todas ellas 

$\hspace{3cm}E \big(T \big(n\big) \big) =  \sum_x^n t \big(x\big)Pr \big(x\big)$

El problema de las monedas
-------------
Se tiene un espacio de muestra S=Cara, Sello. Se tiene una varibale aleatoria $ Y_{i}$ que puede tomar los valores Cara o Sello en la lanzada numero i.
Se define una variable aleatoria indicadora $ X_{i}$, asociada con el evento de que la Variable aleatoria Y sea cara en la lanzada numero i, lo que se denota como:
$ X_{i}=$$I \big\{ Y_{i}=Cara \big\}$  $x =\begin{cases}1 & Si \hspace{1cm}Y_{i}=Cara\\0 &Si\hspace{1cm} Y_{i}=Sello\end{cases}$

Sea X  una varible aleatoria para el numero de caras que se obtienen en el lanzamiento $ x =  \sum_i^n x_{i}  $
$\hspace{3cm}E  \begin{bmatrix}X\end{bmatrix} =E \begin{bmatrix}  \sum_i^n  x_{i} \end{bmatrix}  $

$\hspace{3cm}= \sum_i^n E \begin{bmatrix} x_{i} \end{bmatrix}  $

 $\hspace{5cm}=\sum_i^n \frac{1}{2} $
 
$\hspace{5cm} =\frac{1}{2} $

El problema de la contrataciÃ³n
-------------
1.- Supongamos que necesitas contratar a un nuevo asistente de oficina.
2.-Decides contratar una agencia que te envÃ­a un candidato cada dÃ­a
3.-Decides que despuÃ©s de entrevistar a cada persona sÃ³lo la contratarÃ¡s si el solicitantes estÃ¡ mejor calificado que el asistente actual.

 1 bueno   $\longleftarrow$0
2 **for** i $\longleftarrow$1 to n
3 **do** entreviste al candidato i
4 **if** i es mejor que bueno
5 **then** bueno $\longleftarrow$ i
6 contrate al candidado bueno

> **Nota:**

> - No importa la complejidad del algoritmo HIRE-ASSISTANT, sino los costos concernientes a las entrevistas y a las contrataciones.
> 
> La entrevista tiene un costo bajo $C \big(i\big)  $ .
> - La contratacion tiene un costo alto $C \big(h\big)  $.
> - El costo asociado con el algoritmo es $O \big(C \big(i\big)+C \big(h\big)\big)  $ .

**AnÃ¡lisis**
Peor caso: Se contrata cada candidato entrevistado lo cual implica $O \big(nc \big(h\big)\big) $ . 
AnÃ¡lisis Probabilistico: Se deben hacer distribuciones sobre la posicion de las entradas.

El problema de los sombreros 
-------------
En un restauran hay una persona en la entrada recogiendo los sombreros de las n personas que entran. Cuando sale una persona del restaurante, la persona que esta en la entrada toma un sombrero al azar de todos los que tiene y se lo entrega. Cual es la probabilidad de que le toque su sombrero?.

SoluciÃ³n: 
Sea A=$\big\{$*ninguno de ellos recibe su propio sombrero*$\big\}$, y sea $ A_{i}= \big\{$*el i-enÃ©simo invitado recupera su sombrero/$\big\}$ . Se verifica que $ A^{c} =  \bigcup_4^1  x_{i}$ y por tanto:
$P \big(A\big)=$ $\sum_i^n P \big( A_{i} \big) $ $\sum_r P \big( A_{i} \bigcap  A_{j}  \big) $ 
donde 
$\hspace{3cm}r=1 \leq r\leq r \leq k \leq n$

$P \big( A_{i} \big) =  \frac{ \big(n-1\big) !}{n!} $
$P \big( A_{i} \big) =  \frac{ \big(n-2\big) !}{n!} $
...			$\hspace{5cm}$												....
$P \big( A_{i1} \bigcap... A_{mn}\big)=  \frac{ \big(n-m\big) !}{n!} $

$=1 -  \frac{1}{2!}+\frac{1}{3!}+...+ \big( -1^{n+1} \big)  \frac{1}{n!} $

CÃ³digo
-------------
``` scala
object PermuteBySorting{
  def SelectionSort(A:Array[Int], A2:Array[Int]){
        var Tam = A2.length
        var indice = 0
        var aux = 0
        var menor = 0
        for(i <- 0 to (Tam - 1)){
            indice = i
            menor = A2(i)
            for(j <- (i + 1) to (Tam - 1)){
                if(menor > A2(j)){
                    menor = A2(j)
                    indice = j
                }
            }
            if(indice != i){
                aux = A(indice)
                A(indice) = A(i)
                A(i) = aux
            }
        }
    }
    def PermutaYOrdena(A:Array[Int]){
        val tam = A.length * A.length * A.length
        var A2 = new Array[Int](A.length)
        var azar = new scala.util.Random
        for(i <- 0 to A.length - 1){
            A2(i) = azar.nextInt(tam)
        }
        SelectionSort(A,A2)
    }
    def main(args:Array[String]){
        var A = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        
        println("El arreglo normal es:\n")
        for(i <- A)
            print(i + ", ")
            
        println("\n")
          
        PermutaYOrdena(A)
       
        println("El arreglo Permutado es:\n")
        for(i <- A)
            print(i + ", ")
    }
}
```
