(defproject lisp "0.1.0-SNAPSHOT"
  :description ""
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/core.typed "0.2.51"]
                 [org.clojure/tools.analyzer "0.1.0-beta13"]
                 [org.clojure/tools.analyzer.jvm "0.1.0-beta13"]
                 [org.clojure/tools.reader "0.8.4"]
                 [org.clojure/tools.namespace "0.2.4"]
                 [org.clojure/data.xml "0.0.7"]]
  ;; :main ^:skip-aot lisp.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
