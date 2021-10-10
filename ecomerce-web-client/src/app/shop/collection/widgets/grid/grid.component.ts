import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Product } from '../../../../shared/classes/product';

@Component({
  selector: 'app-grid',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.scss']
})
export class GridComponent implements OnInit {

  @Input() products: Product[] = [];
  @Input() paginate: any = {};
  @Input() layoutView: string = 'grid-view';
  @Input() sortBy: string;

  @Output() sortedBy: EventEmitter<any> = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  sorting(event) {
    this.sortedBy.emit(event.target.value)
  }

}
