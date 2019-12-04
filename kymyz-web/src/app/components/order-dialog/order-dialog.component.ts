import {Component} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {FormControl, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-order-dialog',
  templateUrl: './order-dialog.component.html',
  styleUrls: ['./order-dialog.component.css']
})
export class OrderDialogComponent {

  orderFormGroup = new FormGroup({
      halfCups: new FormControl(null, [Validators.required]),
      fullCups: new FormControl(null, [Validators.required]),
      status: new FormControl('INQUEUE')
    }
  );

  constructor(
    public dialogRef: MatDialogRef<OrderDialogComponent>
  ) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onSubmit() {
    this.dialogRef.close(this.orderFormGroup.value);
  }

  isBadInput() {
    const halfCups = this.orderFormGroup.get('halfCups').value;
    const fullCups = this.orderFormGroup.get('fullCups').value;
    const areIntegers = Number.isInteger(halfCups) && Number.isInteger(fullCups);
    const areNonNegative = halfCups >= 0 && fullCups >= 0;
    return !(areNonNegative && areIntegers);
  }
}






