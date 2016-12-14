package iii_conventions

import util.TODO


class Invokable

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
//    todoTask31()
    return invokable()()()().getNumberOfInvocations()
}

var count: Int = 0

operator fun Invokable.invoke(): Nothing = count ++ as Nothing
fun Invokable.getNumberOfInvocations(): Int = count