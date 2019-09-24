(ns lando.core
  (:gen-class
    :methods [^:static [handler [String] String]]))
 
 (defn -handler [s]
   (str "Hello " s "!"))