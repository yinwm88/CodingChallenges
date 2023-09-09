#include <bits/stdc++.h>
using namespace std;
using vi = vector<int>;

int main()
{
    vi A = {-1, 1, 0, -3, 3};
    int n = A.size();
    vi pfx(n), sfx(n), answer(n);

    /*
        Loop para crear el product prefix array, pero modificado para que el primer elemento del array sea uno.
    */
    pfx[0] = 1;
    for (int i = 1; i < n; i++)
    {
        pfx[i] = pfx[i - 1] * A[i - 1];
    }

    /*
        Loop para crear el product sufix array, pero modificado para que el último elemento del array sea uno.
    */
    sfx[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--)
    {
        sfx[i] = sfx[i + 1] * A[i + 1];
    }

    /*
        Loop para multiplicar el product prefix array y el product sufix array entrada por entrada, para obtener el product of array except self(el arreglo ans).
    */
    for (int i = 0; i < n; i++)
    {
        answer[i] = pfx[i] * sfx[i];
    }

    /*
        Azucár sintactica que imprime el product prefix, el product sufix y el arreglo ans, para ver sus comportamientos  y ver si se obtiene lo solicitado.
    */
    for (auto a : pfx)
        cout << a << " ";
    cout << endl;
    for (auto a : sfx)
        cout << a << " ";
    cout << endl;
    for (auto a : answer)
        cout << a << " ";
    cout << endl;

    return 0;
}