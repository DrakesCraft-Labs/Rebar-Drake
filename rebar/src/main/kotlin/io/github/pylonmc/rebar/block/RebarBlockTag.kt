package io.github.pylonmc.rebar.block

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.Tag
import org.bukkit.block.data.BlockData

class RebarBlockTag(private val key: NamespacedKey, items: Set<BlockTypeWrapper>) : Tag<BlockTypeWrapper> {
    constructor(key: NamespacedKey, vararg materials: Material) : this(key, materials.map { BlockTypeWrapper(it) }.toSet())

    private val items = items.toMutableSet()

    fun add(wrapper: BlockTypeWrapper) {
        items.add(wrapper)
    }

    fun add(material: Material) = add(BlockTypeWrapper(material))

    fun add(blockData: BlockData) = add(BlockTypeWrapper(blockData))

    fun add(schema: RebarBlockSchema) = add(BlockTypeWrapper(schema))

    fun add(key: NamespacedKey) = add(BlockTypeWrapper(key))

    override fun isTagged(block: BlockTypeWrapper): Boolean = block in items
    override fun getValues(): Set<BlockTypeWrapper> = items.toSet()
    override fun getKey(): NamespacedKey = key
}