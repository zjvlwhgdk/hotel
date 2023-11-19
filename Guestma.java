/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.oop2.book.guest;

import java.io.File;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author yeong
 */
public class Guestma {

    int bookNum;//고유번호
    Scanner sc = new Scanner(System.in);
    ArrayList<String> firstName = new ArrayList<String>();
    ArrayList<String> lastName = new ArrayList<String>();
    ArrayList<String> phoneNum = new ArrayList<String>();
    ArrayList<String> guestNum = new ArrayList<String>();
    ArrayList<Integer> roomNum = new ArrayList<Integer>();
    ArrayList<Integer> checkRoom = new ArrayList<Integer>();

    public void Reservation() {
        System.out.print("예약 날짜를 입력하세요 : ");
        String date = sc.nextLine();
        System.out.print("성을 입력하세요 : ");
        String firstname = sc.nextLine();
        firstName.add(bookNum, firstname);
        System.out.print("이름을 입력하세요 : ");
        String lastname = sc.nextLine();
        lastName.add(bookNum, lastname);
        System.out.print("전화번호를 입력하세요 : ");
        String phonenum = sc.nextLine();
        phoneNum.add(bookNum, phonenum);
        System.out.print("투숙객 수를 입력하세요 : "); //TODO 인원수에 따라 방배정,
        String guestnum = sc.nextLine();
        guestNum.add(bookNum, guestnum);
        System.out.print("호실을 선택해주세요 : ");
        int roomnum = sc.nextInt();

        if (roomNum.contains(roomnum)) {
            System.out.println("사용중");
        } else {
            System.out.println("예약 ok");
            System.out.println("고객님의 고유번호는 " + bookNum + "입니다");
            roomNum.add(bookNum, roomnum);

        }
        File memoFile = new File("C:\\Users\\yeong\\d.txt");
        try {

            FileWriter fw = new FileWriter(memoFile, true);
            fw.write("예약 번호 : ");
            fw.write(String.valueOf(bookNum));
            fw.write(" 성 : ");
            fw.write(firstname);
            fw.write(" 이름 : ");
            fw.write(lastname);
            fw.write(" 전화번호 : ");
            fw.write(phonenum);
            fw.write(" 호실 : ");
            fw.write(String.valueOf(roomnum));
            fw.write("\r\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
        }
        bookNum++;
    }

    public void RoomStart() {
        System.out.println("-------------------");
        System.out.println("작업을 선택하십시오");
        System.out.println("1.체크인   2.체크아웃   3.방 상태   4.정보 수정   5.종료");
        System.out.println("-------------------");
        System.out.println();

        int num = sc.nextInt();
        sc.nextLine();

        //int select = Work();
        switch (num) {
            case 1:
                CheckIn();
                break;
            case 2:
                CheckOut();
                break;
            case 3:
                RoomState();
                break;
            case 4:
                Cor();
                break;
            case 5:
                System.out.println("작업을 종료합니다.");
                return;
            default:
                System.out.println("잘못된 선택입니다. 다시 선택하십시오.");

        }

    }

    void CheckIn() {
        System.out.println();
        System.out.println("체크인 내용 기록");
        System.out.print("방 번호 입력: ");
        int checkroom = sc.nextInt();
        if (roomNum.contains(checkroom)) {
            if (checkRoom.contains(checkroom)) {
                System.out.println("이미 체크인이 완료된 방입니다.");
            } else {
                //TODO 정보 확인하고 체크인
                checkRoom.add(checkroom);
                System.out.println("체크인이 완료되었습니다. ");
            }
        } else {
            System.out.println("예약이 되어있지 않은 방입니다. ");
        }
    }

    void CheckOut() {
        System.out.println("체크아웃 하시겠습니까?");
        System.out.println();
        System.out.print("방 번호 입력: ");
        int checkroom = sc.nextInt();
        if (checkRoom.contains(checkroom)) {
            System.out.println("체크아웃 되었습니다. 감사합니다.");
            checkRoom.remove(checkroom);
        } else {
            System.out.println(roomNum + "호는 빈 방 입니다.");

        }

    }

    void RoomState() {
        System.out.println("--------------------");
        System.out.println("방 번호    고객 이름");
        System.out.println("--------------------");
        for (int i = 0; i < 100; i++) {
            if (roomNum.isEmpty()) {

            } else {
                System.out.println(" " + roomNum.get(i) + "호" + "\t" + "방 번호 : " + "\t" + "고객 이름 : " + firstName.get(i) + lastName.get(i));

            }
            System.out.println("--------------------");

        }

        void Cor() {
        System.out.print("수정하려는 호실을 입력해주세요 : ");
            int x = sc.nextInt();
            if (roomNum.contains(x)) {
                int p = roomNum.indexOf(x);
                System.out.println("**************************");

                System.out.println("수정하려는 정보를 선택해주세요");
                System.out.println("1.이름 2.전화번호 3.호실");
                int sel = sc.nextInt();
                switch (sel) {
                    case 1:
                        sc.nextLine();
                        System.out.println("현재 이름은" + firstName.get(p) + lastName.get(p) + "입니다");
                        System.out.print("변경하려는 성을 입력해주세요 : ");
                        String chFirstName = sc.nextLine();
                        firstName.set(p, chFirstName);

                        System.out.print("변경하려는 이름을 입력해주세요 : ");
                        String chLastName = sc.nextLine();
                        lastName.set(p, chLastName);
                        System.out.println(firstName.get(p) + lastName.get(p) + "로 변경되었습니다");
                        break;

                    case 2:

                        System.out.println("현재 전화번호는 " + phoneNum.get(p) + "입니다");
                        System.out.print("변경하려는 전화번호를 입력해주세요 : ");

                        String chphoneNum = sc.nextLine();
                        phoneNum.set(p, chphoneNum);
                        System.out.println(phoneNum.get(p) + "로 전화번호가 변경되었습니다");

                    case 3:
                        while (true) {
                            System.out.println("현재 호실은" + roomNum.get(p) + "입니다");
                            System.out.print("변경하려는 호실을 입력해주세요 : ");
                            sc.nextLine();
                            int chroomNum = sc.nextInt();
                            if (roomNum.contains(chroomNum)) {
                                System.out.println("다른 고객님이 사용중입니다 \n다른 호실을 선택해주세요 : ");
                            } else {
                                roomNum.set(p, chroomNum);
                                System.out.println(roomNum.get(p) + "호로 변경이 완료되었습니다");
                                break;
                            }
                        }

                    default:
                        System.out.println("1,2,3번 중에 입력해라 이놈아");
                        break;
                }
            } else {
                System.out.println("정보가 없습니다");

            }

    }