import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:nexa_uca/app_screens/splash_screen/splash_screen.dart';

class Nexa_Uca extends StatelessWidget {
  const Nexa_Uca({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'NEXA UCA',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: const Color(0xFF03258C)
        ),
      ),
      home: const SplashScreen(),
    );
  }
}