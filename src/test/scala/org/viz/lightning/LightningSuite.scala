package org.viz.lightning

import org.scalatest.FunSuite

class LightningSuite extends FunSuite {

  test("create session") {
    val lgn = Lightning("https://stormy-woodland-3975.herokuapp.com")
    lgn.createSession("test-session")
    assert(lgn.session > 0)
  }

}

