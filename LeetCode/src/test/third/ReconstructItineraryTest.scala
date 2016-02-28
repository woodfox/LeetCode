package third

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class ReconstructItineraryTest extends FunSuite with ShouldMatchers {
  val t = new ReconstructItinerary

  test("shold work") {
    t.findItinerary(Array(Array("JFK","SFO"),Array("JFK","ATL"),Array("SFO","ATL"),Array("ATL","JFK"),Array("ATL","SFO"))).toList should
      be(List("JFK","ATL","JFK","SFO","ATL","SFO"))

    t.findItinerary(Array(Array("MUC", "LHR"),Array("JFK", "MUC"),Array("SFO", "SJC"),Array("LHR", "SFO"))).toList should
      be(List("JFK", "MUC", "LHR", "SFO", "SJC"))

    t.findItinerary(Array(Array("JFK", "KUL"),Array("JFK", "NRT"),Array("NRT", "JFK"))).toList should
      be(List("JFK", "NRT", "JFK", "KUL"))

    t.findItinerary(Array(Array("JFK","ATL"),Array("ORD","PHL"),Array("JFK","ORD"),Array("PHX","LAX"),Array("LAX","JFK"),Array("PHL","ATL"),Array("ATL","PHX"))).toList should
      be(List("JFK","ATL","PHX","LAX","JFK","ORD","PHL","ATL"))
  }
}
