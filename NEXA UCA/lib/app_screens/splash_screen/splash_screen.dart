import 'package:flutter/material.dart';


class SplashScreen extends StatefulWidget{
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();

}

class _SplashScreenState extends State<SplashScreen> with SingleTickerProviderStateMixin {
  late AnimationController _controller;
  late Animation<double> _fadeAnimation;

  @override
  void initState() {
    super.initState();

    _controller = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1200),
    );

    _fadeAnimation = CurvedAnimation(
        parent: _controller,
        curve: Curves.easeIn,
    );

    _controller.forward();
    _navigateToLogin();
  }

  Future<void> _navigateToLogin() async {
    await Future.delayed(const Duration(seconds: 3));
    if (mounted) {
      // TODO: reemplzar cuando se tengamos el login
      // Navigator.pushReplacment(
      // context,
      // MaterialPageRoute(bulder: (_) => const LoginScreen()),
      // );
    }
  }

  @override
  void dispose(){
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
   return Scaffold(
     body: Container(
       decoration: const BoxDecoration(
         gradient: LinearGradient(
             begin: Alignment.topLeft,
             end: Alignment.bottomRight,
             colors: [
               Color(0xFF03258C),
               Color(0xFF001B43),
             ],
         ),
       ),
       child: Center(
         child: FadeTransition(
             opacity: _fadeAnimation,
             child: Image.asset(
               'assets/logos/icon_main_complete.png',
               width: 240
             ),
         ),
       ),
     ),
   );
  }
}