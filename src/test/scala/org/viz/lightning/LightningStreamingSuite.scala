package org.viz.lightning

import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.viz.lightning.types.Make

class LightningStreamingSuite extends FunSuite with BeforeAndAfterAll {

    var lgn: Lightning = _

    override def beforeAll() {
        lgn = Lightning("https://stormy-woodland-3975.herokuapp.com")
        lgn.createSession("test-streaming")
    }

    test("linestreaming") {
      val viz = lgn.linestreaming(
            series = Make.series(n = 5, t = 5),
            label = Make.labels(n = 5),
            size = Make.sizes(n = 5, scale = 7, min = 3))

      for (i <- 1 to 1) {
        viz.append(series = Make.series(n = 5, t = 5))
      }
    }

    test("scatterstreaming") {
      val viz = lgn.scatterstreaming(
            x = Make.gaussian(n = 5, scale = 5),
            y = Make.gaussian(n = 5, scale = 5),
            label = Make.labels(n = 5),
            size = Make.sizes(n = 5))

      for (i <- 1 to 1) {
        viz.append(
              x = Make.gaussian(n = 5, scale = 5),
              y = Make.gaussian(n = 5, scale = 5),
              label = Make.labels(n = 5),
              size = Make.sizes(n = 5))
      }
    }
}
