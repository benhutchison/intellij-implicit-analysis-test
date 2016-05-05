package example

import prickle._

case class Test()

object Example {

  implicit def ineligiblePickler[T, S <: Set[T]]: Pickler[S] = new Pickler[S] {
    def pickle[P](value: S, state: PickleState)(implicit config: PConfig[P]): P = {
      ???
    }
  }


  //On Cmd-Shift-P:
  // Expected: materializePickler
  // Actual: ineligiblePickler
  Pickle.intoString(new Test())

}
