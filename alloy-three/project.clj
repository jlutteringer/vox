(defproject alloy/three "0.1.0-SNAPSHOT"
  :plugins [[lein-modules "0.3.11"] [lein-cljsbuild "1.1.0"]]
  :description "FIXME: write description"
  :dependencies [[alloy/base :version] [cljsjs/three "0.0.72-0"]]
  :source-paths ["src/cljs"]

  :cljsbuild {:builds [{:source-paths ["src/cljs"]

                        :compiler {
                                   :output-to "target/assets/js/alloy/three.js"
                                   :optimizations :whitespace
                                   :pretty-print true
                                   }}]}

  :clean-targets ^{:protect false} [:target-path "target/assets"])