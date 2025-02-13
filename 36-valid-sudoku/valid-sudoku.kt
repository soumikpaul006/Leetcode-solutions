class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set=HashSet<String>()

        for(i in board.indices)
        {
            for(j in board[i].indices)
            {
                val c=board[i][j]

                if(c!='.')//number
                {
                    if(!set.add("row$i$c") || !set.add("col$j$c") || !set.add("box${i/3}${j/3}$c"))
                    {
                        return false
                    }
                }
            }
        }

        return true
    }
}