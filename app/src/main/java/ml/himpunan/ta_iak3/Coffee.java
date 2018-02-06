package ml.himpunan.ta_iak3;

/**
 * Created by hendz on 30/11/17.
 */

class Coffee {
    int quantity = 1;
    int basicPrize = 4000;
    int toppingChocolate = 0;
    int toppingCreamer = 0;

    void quantityIncrement(int n)
    {

        if ((this.quantity + n) < 100 ) {
            this.quantity = this.quantity + n ;
        }
        else {
            this.quantity = 100;
        }

    }
    void quantityDecrement(int n) {

        if ((this.quantity - n) > 1){
            this.quantity = this.quantity - n ;
        }
        else {
            this.quantity = 1;
        }
    }

}
