def myQuickSort(arr):
    """
    Esta función es el punto de entrada para el algoritmo QuickSort.
    Ordena un array de números en su lugar y devuelve el array ordenado.
    
    Args:
    arr (array): El arreglo que se va a ordenar.

    Returns:
    array: El arreglo ordenado.
    """
    n = len(arr)
    
    # Caso base: Si la longitud del array es 0 o 1, no es necesario ordenar.
    if n <= 1:
        return arr
    else:
        # Llama a la función de ordenación recursiva y devuelve el resultado.
        fix = rQS(arr, 0, n - 1)
    return fix

def intercambia(arr, i, j):
    """
    Esta función intercambia dos elementos en un array.

    Params:
    arr (array): La lista en la que se realizará el intercambio.
    i (int): El índice del primer elemento.
    j (int): El índice del segundo elemento.

    Returns:
    None
    """
    e = arr[i]
    arr[i] = arr[j]
    arr[j] = e

def rQS(arr, inicio, fin):
    """
    Esta es la función principal de QuickSort. Ordena un array
    entre los índices inicio y fin.

    Params:
    arr (list): El arreglo que se está ordenando.
    inicio (int): El índice de inicio del arreglo.
    fin (int): El índice de fin del arreglo.

    Returns:
    array: El arreglo ordenado.
    """
    if inicio < fin:
        # Elegir el pivote como el primer elemento en el rango.
        pivote = arr[inicio]
        i = inicio
        j = fin

        while i < j:
            # Mover el índice 'i' hacia la derecha mientras el elemento sea menor o igual al pivote.
            while i < fin and arr[i] <= pivote:
                i += 1
            # Mover el índice 'j' hacia la izquierda mientras el elemento sea mayor que el pivote.
            while arr[j] > pivote:
                j -= 1
            if i < j:
                # Intercambiar los elementos en los índices 'i' y 'j'.
                intercambia(arr, i, j)

        # Intercambiar el pivote con el elemento en el índice 'j'.
        intercambia(arr, inicio, j)

        # Llamar a la función de ordenación recursiva en las submatrices antes y después del pivote.
        rQS(arr, inicio, j - 1)
        rQS(arr, j + 1, fin)
    return arr

messy = [2, 2, 1, 2, 0]
fix = myQuickSort(messy)

for e in fix:
    print(e)
