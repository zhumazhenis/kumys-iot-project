import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) {
  }

  getAllOrders(page: number, size: number) {
    return this.http.get(`/api/orders?page=${page}&size=${size}`);
  }

  getAllOrderEntriesByOrderId(orderId: number) {
    return this.http.get(`/api/orders/${orderId}/order-entries`);
  }

  saveOrder(order: any) {
    return this.http.post(`/api/orders`, order);
  }

}
