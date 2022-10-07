import {Component} from '@angular/core';
import {EcommerceService} from "../services/EcommerceService";

@Component({
    selector: 'app-prices-mode',
    templateUrl: './prices-mode.component.html',
    styleUrls: ['./prices-mode.component.css']
})
export class PricesModeComponent {

    constructor(private ecommerceService: EcommerceService) {
    }

    showPricesMode() {
        this.ecommerceService.getPricesMode().subscribe((mode: number) => {
            alert("Mode of all product prices: " + mode.toFixed(2));
        });
    }
}
