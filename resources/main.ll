declare i32 @puts(i8*)

@.str = constant [14 x i8] c"Hello, world!\00"

define i32 @main () {
  %str = getelementptr [14 x i8]* @.str, i64 0, i64 0
  call i32 @puts(i8* %str)
  ret i32 0
}
