import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {ActivatedRoute} from '@angular/router';
import {switchMap} from 'rxjs/operators';
import {OrderService} from '../../services/order.service';

@Component({
  selector: 'app-order-entries',
  templateUrl: './order-entries.component.html',
  styleUrls: ['./order-entries.component.css']
})
export class OrderEntriesComponent implements OnInit {
  orderEntriesDataSource = new MatTableDataSource([]);
  columnsToDisplay = ['index', 'type', 'status'];

  constructor(
    private route: ActivatedRoute,
    private orderService: OrderService
  ) {
  }

  ngOnInit() {
    this.route.params.pipe(
      switchMap(routeData => this.orderService.getAllOrderEntriesByOrderId(routeData['orderId']))
    ).subscribe(response => {
        this.orderEntriesDataSource.data = response['content'];
      }
    );
  }

}
