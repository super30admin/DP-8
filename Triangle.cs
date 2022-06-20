using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class Triangle
    {
        public int MinimumTotal(IList<IList<int>> triangle)
        {
            int sum = 0;

            int n = triangle.Count;

            for (int i = n - 2; i >= 0; i--)
            {
                for (int j = 0; j <= i; j++)
                {
                    triangle[i][j] = triangle[i][j] + Math.Min(triangle[i + 1][j], triangle[i + 1][j + 1]);
                }
            }

            return triangle[0][0];
        }
    }
}
