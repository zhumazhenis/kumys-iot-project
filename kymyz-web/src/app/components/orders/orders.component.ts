import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {OrderService} from '../../services/order.service';
import {MatDialog} from '@angular/material/dialog';
import {OrderDialogComponent} from '../order-dialog/order-dialog.component';
import {switchMap} from 'rxjs/operators';
import {EMPTY} from 'rxjs';
import {Router} from '@angular/router';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  ordersDataSource = new MatTableDataSource<any>([]);
  columnsToDisplay = ['id', 'fullCups', 'halfCups', 'status'];

  constructor(
    private orderService: OrderService,
    private router: Router,
    public dialog: MatDialog
  ) {
  }

  ngOnInit() {

    this.orderService.getAllOrders(0, 100).subscribe(response => {
        this.ordersDataSource.data = response['content'];
      }
    );
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(OrderDialogComponent, {
        width: '250px'
      }
    );

    dialogRef.afterClosed().pipe(
      switchMap(order => {
          if (order) {
            return this.orderService.saveOrder(order);
          }
          return EMPTY;
        }
      )
    ).pipe(
      switchMap(response => this.orderService.getAllOrders(0, 100))
    ).subscribe(response => {
        this.ordersDataSource.data = response['content'];
      }
    );
  }


  navigateTo(row: any) {
    this.router.navigate(['orders', row.id]);
  }

  getAvailableCups() {
    let s = 0;
    for (const order of this.ordersDataSource.data) {
      s += order['fullCups'];
      s += order['halfCups'];
    }
    if (10 - s >= 0) {
      return 10 - s;
    }
    return 0;
  }
}
