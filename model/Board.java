package model;

class Board {
    private static int height = 25;
    private static int width  = 24;

    private static int[][] board_mtx = new int[height][width];

    Board () {
        mark_outofbounds_on_board();
        mark_rooms_on_board();
    }

    void print_board() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j % width == 0) {
                    System.out.printf("\n");
                }
                System.out.printf("%d ", board_mtx[i][j]);
            } 
        }
        System.out.printf("\n\n");
    }

    int get_house_value (int[] location) {
        return this.board_mtx[location[0]][location[1]];
    }

    private static void mark_outofbounds_on_board() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (
                    (i == 0) ||
                    (j == 0) ||
                    (i == height - 1) ||
                    (j == width - 1)
                    
                ) {
                    board_mtx[i][j] = 1;
                }
            } 

            board_mtx[7][0]   = 0;
            board_mtx[17][0]  = 0;
            board_mtx[24][7]  = 0;
            board_mtx[24][16] = 0;
            board_mtx[18][23] = 0;
            board_mtx[6][23]  = 0;
            board_mtx[0][9]   = 0;
            board_mtx[0][14]  = 0;

            board_mtx[1][17]  = 1;
            board_mtx[1][6]   = 1;
        }
    }

    private static void mark_rooms_on_board() {
        //Kitchen
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 5; j++) {
                board_mtx[i][j]   = 1;
            } 
        }

        //Dinning room
        for (int i = 9; i <= 15; i++) {
            for (int j = 0; j <= 4; j++) {
                board_mtx[i][j]   = 1;
            } 
        }
        for (int i = 10; i <= 15; i++) {
            for (int j = 5; j <= 7; j++) {
                board_mtx[i][j]   = 1;
            } 
        }

        //Dinning room
        for (int i = 19; i <= 24; i++) {
            for (int j = 0; j <= 6; j++) {
                board_mtx[i][j]   = 1;
            } 
        }

        //Entrance
        for (int i = 18; i <= 23; i++) {
            for (int j = 9; j <= 14; j++) {
                board_mtx[i][j]   = 1;
            } 
        }

        //Office
        for (int i = 21; i <= 23; i++) {
            for (int j = 17; j <= 22; j++) {
                board_mtx[i][j]   = 1;
            } 
        }

        //Envelope slot
        for (int i = 10; i <= 15; i++) {
            for (int j = 10; j <= 14; j++) {
                board_mtx[i][j]   = 1;
            } 
        }

        //Library
        for (int i = 14; i <= 18; i++) {
            for (int j = 18; j <= 22; j++) {
                board_mtx[i][j]   = 1;
            } 
        }
        for (int i = 15; i <= 17; i++) {
            board_mtx[i][17]   = 1;
        }

        //Game room
        for (int i = 8; i <= 12; i++) {
            for (int j = 18; j <= 22; j++) {
                board_mtx[i][j]   = 1;
            } 
        }

        //Winter Garden
        for (int i = 1; i <= 4; i++) {
            for (int j = 18; j <= 22; j++) {
                board_mtx[i][j]   = 1;
            } 
        }
        for (int j = 19; j <= 22; j++) {
            board_mtx[5][j]   = 1;
        }

        //Music Room
        for (int i = 2; i <= 7; i++) {
            for (int j = 8; j <= 15; j++) {
                board_mtx[i][j]   = 1;
            } 
        }
        for (int j = 10; j <= 13; j++) {
            board_mtx[1][j]   = 1;
        }

        mark_roomentrances_on_board();
    }

    private static void mark_roomentrances_on_board() {
        //Kitchen
        board_mtx[6][4]  = 2;

        //Dinning room
        board_mtx[12][7] = 2;
        board_mtx[15][6] = 2;

        //Living room
        board_mtx[19][6] = 2;

        //Entrance
        board_mtx[18][11] = 2;
        board_mtx[18][12] = 2;
        board_mtx[20][14] = 2;

        //Office
        board_mtx[21][17] = 2;

        //Library
        board_mtx[16][17] = 2;
        board_mtx[14][20] = 2;

        //Game room
        board_mtx[12][22] = 2;
        board_mtx[9][18]  = 2;

        //Winter garden
        board_mtx[5][19] = 2;

        //Music room
        board_mtx[7][9]  = 2;
        board_mtx[7][14] = 2;
        board_mtx[5][8]  = 2;
        board_mtx[5][15] = 2;
    }
}