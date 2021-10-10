import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'reduceId'
})
export class ReduceIdPipe implements PipeTransform {

  transform(id: string): string {
    return id.substring(0, 6).concat('...')
  }

}
