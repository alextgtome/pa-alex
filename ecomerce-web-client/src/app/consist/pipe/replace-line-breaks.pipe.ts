import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'replaceLineBreaks'
})
export class ReplaceLineBreaksPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return value.replace(/\n/g, '<br/>');
  }

}
