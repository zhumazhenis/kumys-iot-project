import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-commands',
  templateUrl: './commands.component.html',
  styleUrls: ['./commands.component.css']
})
export class CommandsComponent implements OnInit {
  commandsDataSource: MatTableDataSource<any>;

  constructor() {
  }

  ngOnInit() {
  }

}
