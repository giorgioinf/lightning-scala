package org.viz.lightning

import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.viz.lightning.types.Make

class LightningThreeSuite extends FunSuite with BeforeAndAfterAll {

  var lgn: Lightning = _

  override def beforeAll() {
    lgn = Lightning("https://stormy-woodland-3975.herokuapp.com")
    lgn.createSession("test-three")
  }

  test("scatter3") {
    lgn.scatter3(x = Make.values(n = 20),
                 y = Make.values(n = 20),
                 z = Make.values(n = 20),
                 label = Make.labels(n = 20),
                 size = Make.sizes(n = 20))
  }

}