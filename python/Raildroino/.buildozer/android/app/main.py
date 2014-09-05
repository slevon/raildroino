#!/usr/bin/kivy

__author__ = 'slevon'

'''
This is the main entry point for Raildroino:
a Kivy/bluetooth interface for Railduino.

Railduino itself is a CAN interface project for an Arduino that interfaces Märklin Rails

This UI gives a List of all Trains, and a Tabview thar contains the Turnouts and Signals

Future Releases will contain an Edit Function that allows one to edit/add and delete new Trains, Turnouts
and signals directly from the UI
'''


from kivy.app import App
from kivy.uix.widget import Widget
from kivy.uix.boxlayout import BoxLayout


class Raildroino(Widget):
    pass

class CntrlLoco(BoxLayout):
    pass


class RaildroinoApp(App):
    def build(self):
        return Raildroino()


if __name__ == '__main__':
    RaildroinoApp().run()