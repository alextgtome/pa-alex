import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'resumeLineBreak'
})
export class ResumeLineBreakPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return value.substring(0, value.indexOf("\n") );
  }

}
