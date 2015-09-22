
#### Lecture 1.2
* There are two ways to evaluate expressions:
   * evaluate function arguments from left to right, then replace the function application by the function's right hand side, 
	 and at the same time, we replace the former parameters of the function by the actual arguments. (call by value)
	 * apply function' right hand side first, then evaluate the function arguments. (call by name)
* An important theorem, in fact, of lambda calculus is that both strategies reduce to the same final value as long as the
  reduced expression consists of pure functions and both evaluations terminate.

#### Lecture 1.3
	 * If CBV evaluation of an expression terminates, then CBN evaluation of the expression terminates, too.
	 * The other direction is not true! OMG, e.g. first(x, y) = x, first(1, loop)
	 * Scala normally uses call-by-value. If the type of a function parameter starts with '=>', it uses call-by-name. Note that Scala will apply different strategies based on the type of the parameter.

