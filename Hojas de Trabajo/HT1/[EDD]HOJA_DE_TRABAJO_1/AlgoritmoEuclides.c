#include <stdio.h>

int Euclides(int, int);

int main(){
    int a,b,i;
    char opc;
    do{
        printf("\n\tIntroduce el dividendo: ");
            scanf("%d",&a);
        printf("\tIntroduce el divisor: ");
            scanf("%d",&b);
        if(b<0){
            b=-b;
        }
        if(a<0){
            a=-a;
        }
        if(b>a){
            int aux;
            aux=a;
            a=b;
            b=aux;
        }
        printf("\n\tEl m%cximo com%cn divisor es %d",160,163,Euclides(a,b));
        printf("\n\n\t%cDesea volver a utilizar el Programa [s/n]?",168);
            fflush(stdin);
            scanf("%c",&opc);
    }while(opc=='s' || opc=='S');
    return 0;
}

int Euclides(int a, int b){
    if(b==0){
        return a;
    }
    else{
        return Euclides(b,a%b);
    }
}
