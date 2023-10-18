package main

import "fmt"

// projectionArea calcula el área de una figura 3D dado su matriz asociada.
func projectionArea(grid [][]int) int {
	xy:=0 
	maxc:=0 
	maxf:=0 
	proyeccion := 0	
	
	for i:= 0; i<len(grid); i++{
		maxc=0
		maxf=0

		for j:=0; j<len(grid[0]); j++{
			
			if grid[i][j] > maxf{
				maxf = grid[i][j]
			}

			if grid[j][i] > maxc{
				maxc = grid[j][i]
			}

			if grid[i][j]!=0{
				xy = xy+1
			}
		}

		proyeccion += maxf + maxc
	}
	return proyeccion + xy
}

func main() {	
	matriz := [][]int{
        {1, 2},
        {3, 4},
    }

	resultado := projectionArea(matriz)
    fmt.Printf("Proyección: %d\n", resultado)
}
