import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.scss']
})
export class TableListComponent implements OnInit {

  @Input()
  data: any;

  @Input()
  columns: Array<String>;
  
  @Output()
  dataSelected: EventEmitter<any>;


  constructor() {
    this.dataSelected = new EventEmitter(); }

  ngOnInit() {
    console.log(this.data);
  }

  selectData(data: any) {
    this.dataSelected.emit(data);
  }

}
