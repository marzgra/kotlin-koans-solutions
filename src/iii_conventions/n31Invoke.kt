package iii_conventions

import util.TODO


class Invokable{
    private var counter: Int = 0
    fun getNumberOfInvocations() : Int {
        return counter
    }

    operator fun invoke() : Invokable{
       ++counter
        return this
    }
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change the class 'Invokable' to count the number of invocations:
        for 'invokable()()()()' it should be 4.
    """,
    references = { invokable: Invokable -> })


fun task31(invokable: Invokable): Int {
//    todoTask31()
    return invokable()()()().getNumberOfInvocations()
}


