import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {OrdersComponent} from './components/orders/orders.component';
import {OrderEntriesComponent} from './components/order-entries/order-entries.component';


const routes: Routes = [
  {path: 'orders', component: OrdersComponent},
  {path: 'orders/:orderId', component: OrderEntriesComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
