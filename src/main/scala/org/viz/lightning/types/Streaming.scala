package org.viz.lightning.types

import org.viz.lightning.Lightning
import org.viz.lightning.Visualization

class VisualLineStreaming(viz:Visualization) extends Visualization(viz.lgn, viz.id, viz.name) {

    def append(series: Array[Array[Double]],
            index: Array[Int] = Array[Int](),
            color: Array[Array[Int]] = Array[Array[Int]](),
            label: Array[Int] = Array[Int](),
            size: Array[Double] = Array[Double](),
            xaxis: String = "",
            yaxis: String = "") = {

        val data = Map("series" -> series.toList)

        val settings = new Settings()
          .append(List(Index(index), Color(color), Label(label), Size(size)))
          .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

        lgn.postData(getDataLink, data ++ settings.toMap, name)
    }
}

class VisualScatterStreaming(viz:Visualization) extends Visualization(viz.lgn, viz.id, viz.name) {

    def append(x: Array[Double], y: Array[Double],
            color: Array[Array[Int]] = Array[Array[Int]](),
            label: Array[Int] = Array[Int](),
            size: Array[Double] = Array[Double](),
            xaxis: String = "",
            yaxis: String = "") = {


        val points = Utils.getPoints(x, y)
        val data = Map("points" -> points.toList)

        val settings = new Settings()
          .append(List(Color(color), Label(label), Size(size)))
          .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

        lgn.postData(getDataLink, data ++ settings.toMap, name)
    }
}

trait Streaming extends Base {

    def linestreaming(series: Array[Array[Double]],
                index: Array[Int] = Array[Int](),
                color: Array[Array[Int]] = Array[Array[Int]](),
                label: Array[Int] = Array[Int](),
                size: Array[Double] = Array[Double](),
                xaxis: String = "",
                yaxis: String = ""): VisualLineStreaming = {


        val data = Map("series" -> series.toList)

        val settings = new Settings()
          .append(List(Index(index), Color(color), Label(label), Size(size)))
          .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

        new VisualLineStreaming(plot("line-streaming", data ++ settings.toMap))
    }

    def scatterstreaming(x: Array[Double], y: Array[Double],
            color: Array[Array[Int]] = Array[Array[Int]](),
            label: Array[Int] = Array[Int](),
            size: Array[Double] = Array[Double](),
            xaxis: String = "",
            yaxis: String = ""): VisualScatterStreaming = {

        val points = Utils.getPoints(x, y)
        val data = Map("points" -> points.toList)

        val settings = new Settings()
          .append(List(Color(color), Label(label), Size(size)))
          .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

        new VisualScatterStreaming(plot("scatter-streaming", data ++ settings.toMap))
    }
}