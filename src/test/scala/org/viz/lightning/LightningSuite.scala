package org.viz.lightning

import org.scalatest.{BeforeAndAfterAll, FunSuite}

class LightningSuite extends FunSuite with BeforeAndAfterAll {

  var lgn: Lightning = _

  override def beforeAll() {
    lgn = Lightning("https://stormy-woodland-3975.herokuapp.com")
  }

  test("create session") {
    lgn.createSession("test-session")
    assert(lgn.session > 0)
  }
}

