import { Injectable } from '@angular/core';
import { Todo } from './todo';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private todoUrl = 'api/todos'

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  constructor(private http: HttpClient) { }

getTodos(): Observable<Todo[]> {
  return this.http.get<Todo[]>(this.todoUrl).pipe(
    tap(_ => console.log('fetched todos')),
    catchError(this.handleError<Todo[]>('getTodos', []))
  )
} 

deleteTodo(id: number): Observable<Todo> {
  const url = `${this.todoUrl}/${id}`;

  return this.http.delete<Todo>(url, this.httpOptions).pipe(
    tap(_ => console.log(`deleted todo id=${id}`)),
    catchError(this.handleError<Todo>('deleteHero'))
  )
}

addTodo(todo: Todo): Observable<Todo> {
  return this.http.post<Todo>(this.todoUrl, todo, this.httpOptions).pipe(
    tap((newTodo: Todo) => console.log(`added todo id=${newTodo.id}`)),
    catchError(this.handleError<Todo>('addTodo'))
  )
}


  /**
 * Handle Http operation that failed.
 * Let the app continue.
 *
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
private handleError<T>(operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {
    console.error(error); // log to console instead
    // Let the app keep running by returning an empty result.
    return of(result as T);
  };
}
}


