class DeleteDataStructElement {
    val elementsMap = mutableMapOf<Int, Node>()
    private var head: Node? = null
    private var tail: Node? = null
    inner class Node(val value: Int) {
        var next: Node? = null
        var prev: Node? = null
    }
    fun insert(value: Int) {
        if (elementsMap.containsKey(value)) {
            return
        }
        val newNode = Node(value)
        elementsMap[value] = newNode
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.prev = tail
            tail?.next = newNode
            tail = newNode
        }
    }
    fun delete(value: Int) {
        val nodeToRemove = elementsMap[value] ?: return
        val prevNode = nodeToRemove.prev
        val nextNode = nodeToRemove.next
        if (prevNode != null) {
            prevNode.next = nextNode
        } else {
            head = nextNode
        }
        if (nextNode != null) {
            nextNode.prev = prevNode
        } else {
            tail = prevNode
        }
        elementsMap.remove(value)
    }
}
fun main() {
    val dataStructure = DeleteDataStructElement()
    dataStructure.insert(1)
    dataStructure.insert(2)
    dataStructure.insert(3)
    println("ელემენტების სია წაშლამდე: " +dataStructure.elementsMap.keys)

    dataStructure.delete(2)
    println("ელემენტების სია წაშლის მერე: " + dataStructure.elementsMap.keys)
}
