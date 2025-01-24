/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labexam139;

class Labexam139 {
    private int totalSeats = 20; 
    public synchronized void bookSeats(String user, int seatsRequested) {
        if (seatsRequested > totalSeats) {
           
            System.out.println(user + ": Not enough seats available.");
            return;
        }

        totalSeats -= seatsRequested;
        System.out.println(user + " booked " + seatsRequested + " seats.");
        System.out.println("Remaining seats: " + totalSeats);
    }

    public static void main(String[] args) {
        Labexam139 app = new Labexam139();

        Thread userA = new Thread(() -> {
            app.bookSeats("User A", 10);
        });

        Thread userB = new Thread(() -> {
            app.bookSeats("User B", 12);
        });

        userA.start();
        userB.start();
    }
}

