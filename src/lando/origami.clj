(ns lando.origami
    (:require [opencv4.core :refer :all])
    (:gen-class
      :methods [^:static [handler [String] String]]))


(defn -handler [s]
   (str "Using OpenCV Version: " VERSION ".."))