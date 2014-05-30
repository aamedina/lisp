(ns lisp.core
  (:refer-clojure :exclude [eval])  
  (:require [clojure.core.typed :as ty :refer :all
             :exclude [doseq fn for let dotimes defprotocol loop def]]
            [clojure.tools.namespace.repl :refer [refresh-all]]
            [clojure.core :as core]))


