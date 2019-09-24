(defproject lando "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :repositories [["vendredi" "https://repository.hellonico.info/repository/hellonico/"]]
  :dependencies [
    [org.clojure/clojure "1.10.0"]
    [origami-dnn "0.1.5"]
     ; [origami "4.1.1-6"]
    [cheshire "5.9.0"]
  ]
  ; :main lando.core
  :profiles {
    :uberjar {:aot :all}
  }
  :repl-options {:init-ns lando.core})
