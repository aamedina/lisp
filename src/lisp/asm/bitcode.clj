(ns lisp.asm.bitcode
  (:require [clojure.data.xml :as xml]
            [clojure.java.io :as io]
            [clojure.zip :as zip]
            [clojure.pprint :refer [pprint]]
            [clojure.edn :as edn]
            [clojure.set :as set]
            [clojure.tools.namespace.repl :refer [refresh-all]]))

(def bitcode (edn/read-string (slurp (io/resource "main.edn"))))

(defmulti parse (fn [[op & _]] op))

(defmethod parse 0x8
  [[op & more :as bitstream]]
  :MODULE_BLOCK)

(defmethod parse 0x9
  [[op & more :as bitstream]]
  :PARAMATTR_BLOCK)

(defmethod parse 0xA
  [[op & more :as bitstream]]
  :TYPE_BLOCK)

(defmethod parse 0xB
  [[op & more :as bitstream]]
  :CONSTANTS_BLOCK)

(defmethod parse 0xC
  [[op & more :as bitstream]]
  :FUNCTION_BLOCK)

(defmethod parse 0xD
  [[op & more :as bitstream]]
  :TYPE_SYMTAB_BLOCK)

(defmethod parse 0xE
  [[op & more :as bitstream]]
  :VALUE_SYMTAB_BLOCK)

(defmethod parse 0xF
  [[op & more :as bitstream]]
  :METADATA_BLOCK)

(defmethod parse 0x10
  [[op & more :as bitstream]]
  :METADATA_ATTACHMENT)

(defmethod parse :default
  [[op & more :as bitstream]]
  :default)

(defmulti emit (fn [[op attrs & content]] op))

(defmethod emit :MODULE_BLOCK
  [[op & more :as bitstream]]
  0x8)

(defmethod emit :PARAMATTR_BLOCK
  [[op & more :as bitstream]]
  0x9)

(defmethod emit :TYPE_BLOCK
  [[op & more :as bitstream]]
  0xA)

(defmethod emit :CONSTANTS_BLOCK
  [[op & more :as bitstream]]
  0xB)

(defmethod emit :FUNCTION_BLOCK
  [[op & more :as bitstream]]
  0xC)

(defmethod emit :TYPE_SYMTAB_BLOCK
  [[op & more :as bitstream]]
  0xD)

(defmethod emit :VALUE_SYMTAB_BLOCK
  [[op & more :as bitstream]]
  0xE)

(defmethod emit :METADATA_BLOCK
  [[op & more :as bitstream]]
  0xF)

(defmethod emit :METADATA_ATTACHMENT
  [[op & more :as bitstream]]
  0x10)

(defmethod emit :default
  [[op & more :as bitstream]]
  :unknown)
